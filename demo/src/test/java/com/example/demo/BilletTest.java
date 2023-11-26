package com.example.demo;

import com.example.demo.controller.ClientController;
import com.example.demo.controller.StadeController;
import com.example.demo.service.StadeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(StadeController.class)
class StadeTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private StadeService stadeService;

    @Test
    void testGetAllStades() throws Exception {
        MvcResult result = mvc.perform(get("/eco"))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println("Response: " + result.getResponse().getContentAsString());

        mvc.perform(get("/eco"))
                .andExpect(jsonPath("$[0].information_contrat").value("inocontrat"))
                .andExpect(jsonPath("$[0].address").value("sale"))
                .andExpect(jsonPath("$[0].nom").value("Article_1"))
                .andExpect(jsonPath("$[0].plan_stock").value("Planstock"))
                .andExpect(jsonPath("$[0].capacite_stock").value(10))
                .andReturn();


    }



    @Test
    void testGetArticleById() throws Exception {
        mvc.perform(get("/eco/1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Article_1"))
                .andExpect(jsonPath("$.address").value("sale"))
                .andExpect(jsonPath("$.information_contrat").value("inocontrat"))
                .andExpect(jsonPath("$.plan_stock").value("Planstock"))
                .andExpect(jsonPath("$.capacite_stock").value(10));
    }
    @Test
    void testDeleteArticle() throws Exception {
        // Supposons que l'ID 1 correspond à une ressource existante que vous souhaitez supprimer
        long articleIdToDelete = 3;

        // Effectuez la suppression de la ressource
        mvc.perform(MockMvcRequestBuilders.delete("/eco/{id}", articleIdToDelete)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Assurez-vous que la ressource a été supprimée en tentant de la récupérer
        mvc.perform(MockMvcRequestBuilders.get("/eco/{id}", articleIdToDelete)
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
                + "\"information_contrat\":\"UpdatedContractInfo\","
                + "\"plan_stock\":\"UpdatedPlan\","
                + "\"capacite_stock\":20"
                + "}";


        // Send a request to update the article
        mvc.perform(MockMvcRequestBuilders.put("/eco/updateStade")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedStadeJson)  // updatedStadeJson is a JSON representation of your Stade object
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());


        // Verify that the article has been updated by fetching it again
        mvc.perform(MockMvcRequestBuilders.get("/eco/1", articleIdToUpdate)
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
