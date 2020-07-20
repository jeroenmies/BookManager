package nl.ufp.books.rest;

import nl.ufp.books.Book;
import nl.ufp.books.repository.BooksRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BooksControllerTest {

    private BooksRepository booksRepository = Mockito.mock(BooksRepository.class);

    private BooksController booksController = new BooksController(booksRepository);

    private MockMvc mockMvc = MockMvcBuilders
            .standaloneSetup(booksController)
            .build();

    @Test
    public void listEndpointPresentsListOfBooks() throws Exception {
        when(booksRepository.findAll()).thenReturn(emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.books", equalTo(emptyList())));
    }

    @Test
    public void listEndpointPresentsListOfBooksWhenThereAreBooks() throws Exception {
        when(booksRepository.findAll()).thenReturn(asList(new Book("Ivanhoe"), new Book("Robin Hood")));

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.books", hasSize(2)))
                .andExpect(jsonPath("$.books[0].title", equalTo("Ivanhoe")))
                .andExpect(jsonPath("$.books[1].title", equalTo("Robin Hood")));
    }
}
