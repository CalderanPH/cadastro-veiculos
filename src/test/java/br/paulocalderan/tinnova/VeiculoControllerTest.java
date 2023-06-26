package br.paulocalderan.tinnova;

import br.paulocalderan.tinnova.exception.InvalidMarcaException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.HttpHeaders.LOCATION;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.web.util.UriComponentsBuilder.fromPath;

public class VeiculoControllerTest extends TinnovaApplicationTests {

    @Test
    @DisplayName("Pega todos os veiculos")
    void caseOne() throws Exception {
        mockMvc.perform(get("/veiculos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nome").value("F-Type"))
                .andExpect(jsonPath("$[0].marca").value("Jaguar"))
                .andExpect(jsonPath("$[0].ano").value(2020))
                .andExpect(jsonPath("$[0].descricao").value("Exemplo"))
                .andExpect(jsonPath("$[0].vendido").value(false))
                .andExpect(jsonPath("$[0].cor").value("Prata"))
                .andDo(print());
    }

    @Test
    @DisplayName("Pega todos os veiculos com base no filtro")
    void caseTwo() throws Exception {
        mockMvc.perform(get("/veiculos/filter")
                        .param("marca", "")
                        .param("ano", "")
                        .param("cor", "Prata"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nome").value("F-Type"))
                .andExpect(jsonPath("$[0].marca").value("Jaguar"))
                .andExpect(jsonPath("$[0].ano").value(2020))
                .andExpect(jsonPath("$[0].descricao").value("Exemplo"))
                .andExpect(jsonPath("$[0].vendido").value(false))
                .andExpect(jsonPath("$[0].cor").value("Prata"))
                .andDo(print());
    }

    @Test
    @DisplayName("Pega o veiculo por id")
    void caseThree() throws Exception {
        String uri = fromPath("/veiculos/{id}").buildAndExpand("08772d53-48c3-49c3-b0de-8c41ffb5ae43").toUriString();

        mockMvc.perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nome").value("F-Type"))
                .andExpect(jsonPath("$.marca").value("Jaguar"))
                .andExpect(jsonPath("$.ano").value(2020))
                .andExpect(jsonPath("$.descricao").value("Exemplo"))
                .andExpect(jsonPath("$.vendido").value(false))
                .andExpect(jsonPath("$.cor").value("Prata"))
                .andDo(print());
    }

    @Test
    @DisplayName("Pega os veiculos que não foram vendidos")
    void caseFour() throws Exception {
        mockMvc.perform(get("/veiculos/nao-vendidos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nome").value("F-Type"))
                .andExpect(jsonPath("$[0].marca").value("Jaguar"))
                .andExpect(jsonPath("$[0].ano").value(2020))
                .andExpect(jsonPath("$[0].descricao").value("Exemplo"))
                .andExpect(jsonPath("$[0].vendido").value(false))
                .andExpect(jsonPath("$[0].cor").value("Prata"))
                .andDo(print());
    }

    @Test
    @DisplayName("Pega os veiculos por decada")
    void caseFive() throws Exception {
        mockMvc.perform(get("/veiculos/decada")
                        .param("ano", String.valueOf(2023)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nome").value("F-Type"))
                .andExpect(jsonPath("$[0].marca").value("Jaguar"))
                .andExpect(jsonPath("$[0].ano").value(2020))
                .andExpect(jsonPath("$[0].descricao").value("Exemplo"))
                .andExpect(jsonPath("$[0].vendido").value(false))
                .andExpect(jsonPath("$[0].cor").value("Prata"))
                .andDo(print());
    }

    @Test
    @DisplayName("Pega veiculo por marca no path")
    void caseSix() throws Exception {
        mockMvc.perform(get("/veiculos/marca/Jaguar"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nome").value("F-Type"))
                .andExpect(jsonPath("$[0].marca").value("Jaguar"))
                .andExpect(jsonPath("$[0].ano").value(2020))
                .andExpect(jsonPath("$[0].descricao").value("Exemplo"))
                .andExpect(jsonPath("$[0].vendido").value(false))
                .andExpect(jsonPath("$[0].cor").value("Prata"))
                .andDo(print());
    }

    @Test
    @DisplayName("Deve retornar vazio, não há cadastro na ultima semana")
    void caseSeven() throws Exception {
        mockMvc.perform(get("/veiculos/ultima-semana"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"))
                .andDo(print());
    }

    @Test
    @DisplayName("Cadastro de Veiculo")
    void caseEight() throws Exception {
        String uri = fromPath("/veiculos").toUriString();

        mockMvc.perform(post(uri)
                        .content(getContentFromResource("/json/veiculo.json")
                                .replace("{{nome}}", "Palio")
                                .replace("{{marca}}", "Fiat")
                                .replace("{{ano}}", "2013")
                                .replace("{{descricao}}", "Exemplo")
                                .replace("{{vendido}}", "true")
                                .replace("{{cor}}", "Preto"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(header().string(LOCATION, containsString(uri)))
                .andDo(print());
    }

    @Test
    @DisplayName("Deve estourar exception se o nome da marca estiver errado")
    void caseNine() throws Exception {
        String uri = fromPath("/veiculos").toUriString();

        Exception exception = assertThrows(Exception.class, () -> {
            mockMvc.perform(post(uri)
                    .content(getContentFromResource("/json/veiculo.json")
                            .replace("{{nome}}", "Palio")
                            .replace("{{marca}}", "Fiati")
                            .replace("{{ano}}", "2013")
                            .replace("{{descricao}}", "Exemplo")
                            .replace("{{vendido}}", "true")
                            .replace("{{cor}}", "Branco"))
                    .contentType(MediaType.APPLICATION_JSON));
        });
        assertTrue(exception.getCause() instanceof InvalidMarcaException);
    }

    @Test
    @DisplayName("Altera o veiculo")
    void caseTen() throws Exception {
        String uri = fromPath("/veiculos/{id}").buildAndExpand("08772d53-48c3-49c3-b0de-8c41ffb5ae43").toUriString();

        mockMvc.perform(put(uri)
                        .content(getContentFromResource("/json/veiculo.json")
                                .replace("{{nome}}", "Palio")
                                .replace("{{marca}}", "Fiat")
                                .replace("{{ano}}", "2013")
                                .replace("{{descricao}}", "Exemplo")
                                .replace("{{vendido}}", "true")
                                .replace("{{cor}}", "Preto"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @Test
    @DisplayName("Altera apenas o status do veiculo de Vendido para true/false")
    void caseEleven() throws Exception {
        String uri = fromPath("/veiculos/{id}").buildAndExpand("08772d53-48c3-49c3-b0de-8c41ffb5ae43").toUriString();

        mockMvc.perform(patch(uri)
                        .content(getContentFromResource("/json/veiculo.json")
                                .replace("{{vendido}}", "true"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @Test
    @DisplayName("Deleta o veiculo")
    void caseTwelve() throws Exception {
        String uri = fromPath("/veiculos/{id}").buildAndExpand("08772d53-48c3-49c3-b0de-8c41ffb5ae43").toUriString();

        mockMvc.perform(delete(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

}