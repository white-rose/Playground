import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;
import sun.jvm.hotspot.debugger.Page;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PaginationController {

   @RequestMapping(params = { "page", "size" }, method = RequestMethod.GET)
   @ResponseBody
   public List<Foo> findPaginated(@RequestParam("page") final int page
           , @RequestParam("size") final int size
           , final UriComponentsBuilder uriBuilder
           , final HttpServletResponse response) {
//       final Page<Foo> resultsPage = service.findPaginated(page, size);
//       if (page > resultsPage.getTotalPages())
       return null;
   }

}


