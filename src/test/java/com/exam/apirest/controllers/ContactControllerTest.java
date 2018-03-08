package com.exam.apirest.controllers;

import com.exam.apirest.model.Address;
import com.exam.apirest.model.Contact;
import com.exam.apirest.repositories.ContactRepository;
import com.exam.apirest.services.impl.ContactServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Equals;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;
import java.util.Date;

@RunWith(SpringRunner.class)
public class ContactControllerTest {
    @SpyBean
    ContactController contactController;

    @MockBean
    ContactRepository contactRepository;

    @SpyBean
    ContactServiceImpl contactService;

    private MockMvc mockMvc;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(contactController).build();

        Mockito.when(contactRepository.findByIdContact(1)).thenReturn(getContact());
    }

    private Contact getContact() {
        Contact contact = new Contact();
        contact.setIdContact(1);
        contact.setProfileImage("123");
        contact.setPhoneNumberWork("1234-1234");
        contact.setPhoneNumberPersonal("1212-1221");
        contact.setName("Pedro");
        contact.setEmail("pedro@gmail.com");
        contact.setCompany("Coto");
        contact.setBirthDate(new Date());
        Address address = new Address();
        address.setCity("San Salvador");
        address.setCountry("Argentina");
        address.setState("Jujuy");
        address.setStreet("Carapachay");
        contact.setAddress(address);
        return contact;
    }

    @Test
    public void getByIdContactTest() throws Exception {
        ResultActions res=mockMvc.perform(MockMvcRequestBuilders.get("/contacts/1").contentType(contentType));
        res.andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.jsonPath("name", new Equals("Pedro"))).
                andExpect(MockMvcResultMatchers.jsonPath("idContact", new Equals(1))).
                andExpect(MockMvcResultMatchers.jsonPath("profileImage",new Equals("123"))).
                andExpect(MockMvcResultMatchers.jsonPath("phoneNumberWork",new Equals("1234-1234"))).
                andExpect(MockMvcResultMatchers.jsonPath("phoneNumberPersonal", new Equals("1212-1221"))).
                andExpect(MockMvcResultMatchers.jsonPath("email", new Equals("pedro@gmail.com"))).
                andExpect(MockMvcResultMatchers.jsonPath("company", new Equals("Coto"))).
                andExpect(MockMvcResultMatchers.jsonPath("address.city", new Equals("San Salvador"))).
                andExpect(MockMvcResultMatchers.jsonPath("address.country",new Equals("Argentina"))).
                andExpect(MockMvcResultMatchers.jsonPath("address.state",new Equals("Jujuy"))).
                andExpect(MockMvcResultMatchers.jsonPath("address.street",new Equals("Carapachay")));
    }

    @Test
    public void getByIdContactExceptionTest() throws Exception {
        ResultActions res=mockMvc.perform(MockMvcRequestBuilders.get("/contacts/abc").contentType(contentType));
        res.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
