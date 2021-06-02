package com.igarciadev.openapi;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class OpenapiApplicationTests
{
    private static final String POSTS_PATH = "/api/v1/posts";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenGetAll_thenStatusIsOK() throws Exception
    {
        this.mockMvc.perform(get(POSTS_PATH)).andExpect(status().isOk());
    }

    @Test
    void whenGetOne_thenStatusIsOk() throws Exception
    {
        //@f:off
        this.mockMvc.perform(get(POSTS_PATH + "/" + 1))
                    .andExpect(status().isOk());
        //@f:on
    }

    @Test
    void whenPostOne_thenStatusIsOk() throws Exception
    {
        String json = "[{\"title\":\"Programación Java 8\",\"publishedDate\":\"2021-05-15\"}]";

        //@f:off
        this.mockMvc.perform(post(POSTS_PATH)
                                     .contentType(MediaType.APPLICATION_JSON_VALUE)
                                     .content(json))
                    .andExpect(status().isOk());
        //@f:on
    }

    @Test
    void whenPutOne_thenStatusIsOk() throws Exception
    {
        String json = "{\"id\":1,\"title\":\"Programación Java 8\"," +
                "\"publishedDate\":\"2021-05-15\"}";

        //@f:off
        this.mockMvc.perform(put(POSTS_PATH + "/" + 1)
                                     .contentType(MediaType.APPLICATION_JSON_VALUE)
                                     .content(json))
                    .andExpect(status().isOk());
        //@f:on
    }

    @Test
    void whenDeleteOne_thenStatusIsOk() throws Exception
    {
        //@f:off
        this.mockMvc.perform(delete(POSTS_PATH + "/" + 2))
                    .andExpect(status().isOk());
        //@f:on
    }
}
