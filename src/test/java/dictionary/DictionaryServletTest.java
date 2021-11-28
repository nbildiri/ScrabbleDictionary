package dictionary;


import org.junit.jupiter.api.Test;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.*;

class DictionaryServletTest {

    @Test
    void doGet() throws IOException {

        // given
        DictionaryServlet servlet = new DictionaryServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter out = mock(PrintWriter.class);
        doReturn(out).when(response).getWriter();
        doReturn("cutie").when(request).getParameter("word");

        // when
        servlet.doGet(request, response);

        // then
        verify(out).println(anyString());

    }
}