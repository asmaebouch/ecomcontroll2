package com.example.demo;

import com.example.demo.controller.ClientController;
import com.example.demo.model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest(ClientController.class)

public class ClientTest {

    @Autowired
    WebApplicationContext context;

    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    void testGetAllClient() throws Exception {
        MvcResult result = mvc.perform(get("/cli"))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println("Response: " + result.getResponse().getContentAsString());

        mvc.perform(get("/cli"))
                .andExpect(jsonPath("$[0].nom").value("inocontrat"))
                .andExpect(jsonPath("$[0].address").value("sale"))
                .andExpect(jsonPath("$[0].telephone").value(000000000))
                .andExpect(jsonPath("$[0].historique").value("Historique"))
                .andReturn();


    }
    @Test
    void testGetArticleById() throws Exception {
        mvc.perform(get("/cli/1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("inocontrat"))
                .andExpect(jsonPath("$.address").value("sale"))
                .andExpect(jsonPath("$.telephone").value(000000000))
                .andExpect(jsonPath("$.historique").value("Historique"))
;    }
    @Test
    void testRegistreForm() throws Exception {
        // Créer un objet Client pour simuler les données du formulaire
        Client client = new Client();
        client.setNom("NomTest");
        client.setAddress("AdresseTest");
        client.setTelephone(123456789);
        client.setHistorique("HistoriqueTest");

        // Convertir l'objet Client en JSON
        String clientJson = objectMapper.writeValueAsString(client);

        mvc.perform(post("/cli/Save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(clientJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("NomTest")) // Vérifiez les valeurs attendues
                .andExpect(jsonPath("$.address").value("AdresseTest"))
                .andExpect(jsonPath("$.telephone").value(123456789))
                .andExpect(jsonPath("$.historique").value("HistoriqueTest"));
    }
    @Test
    void testDeleteArticle() throws Exception {
        // Supposons que l'ID 1 correspond à une ressource existante que vous souhaitez supprimer
        long articleIdToDelete = 2;

        // Effectuez la suppression de la ressource
        mvc.perform(MockMvcRequestBuilders.delete("/cli/{id}", articleIdToDelete)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Assurez-vous que la ressource a été supprimée en tentant de la récupérer
        mvc.perform(MockMvcRequestBuilders.get("/cli/{id}", articleIdToDelete)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
    @Test
    void testUpdateArticle() throws Exception {
        long articleIdToUpdate = 1; // Assuming ID 1 corresponds to an existing article

        // Define the updated content for the article
// Create a JSON object representing the Stade object to update
        String updatedStadeJson = "{"
                + "\"id\":1,"
                + "\"nom\":\"UpdatedName\","
                + "\"address\":\"UpdatedAddress\","
                + "\"telephone\":\"UpdatedContractInfo\","
                + "\"historique\":\"UpdatedPlan\","
                + "\"capacite_stock\":20"
                + "}";


        // Send a request to update the article
        mvc.perform(MockMvcRequestBuilders.put("/cli/updateClient")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedStadeJson)  // updatedStadeJson is a JSON representation of your Stade object
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());


        // Verify that the article has been updated by fetching it again
        mvc.perform(MockMvcRequestBuilders.get("/cli/1", articleIdToUpdate)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("UpdatedName"))
                .andExpect(jsonPath("$.address").value("UpdatedAddress"))
                .andExpect(jsonPath("$.information_contrat").value("UpdatedContractInfo"))
                .andExpect(jsonPath("$.plan_stock").value("UpdatedPlan"))
                .andExpect(jsonPath("$.capacite_stock").value(20));
    }

}
