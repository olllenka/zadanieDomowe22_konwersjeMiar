import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calcmeter")
public class ConversionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        if(request.getParameter("metric")!=null){

            String metre = request.getParameter("metre");
            String centimetre = request.getParameter("centimetre");
            String millimetre = request.getParameter("millimetre");

            writer.println("podane wartości: " + metre + ", " + centimetre + ", " + millimetre );

            if (tooManyValues(metre, centimetre, millimetre))
                writer.println("<h1>Należy wypełnić tylko jedno pole!</h1>");
            else {
                MetricConversion metricConversion = new MetricConversion(metre, centimetre, millimetre);
                writer.println("<h1>Podana wartość w przeliczeniu na:</h1><br/>");
                writer.println(String.format("<h2>metry: %.2f </h2><br/>", metricConversion.getMetre()));
                writer.println(String.format("<h2>centymetry: %.2f </h2><br/>", metricConversion.getCentimetre()));
                writer.println(String.format("<h2>milimetry: %.2f </h2><br/>", metricConversion.getMillimetre()));
            }
        }

        else if(request.getParameter("weight")!=null) {
            String kilogram = request.getParameter("kilogram");
            String gram = request.getParameter("gram");
            String milligram = request.getParameter("milligram");

            writer.println("podane wartości wagi: " + kilogram + ", " + gram + ", " + milligram);

            if (tooManyValues(kilogram, gram, milligram))
                writer.println("<h1>Należy wypełnić tylko jedno pole!</h1>");
            else {
                WeightConversion weightConversion = new WeightConversion(kilogram, gram, milligram);
                writer.println("<h1>Podana wartość w przeliczeniu na:</h1><br/>");
                writer.println(String.format("<h2>kilogramy: %.2f </h2><br/>", weightConversion.getKilogram()));
                writer.println(String.format("<h2>gramy: %.2f </h2><br/>", weightConversion.getGram()));
                writer.println(String.format("<h2>miligramy: %.2f </h2><br/>", weightConversion.getMilligram()));
            }
        }
    }

    private boolean tooManyValues(String value1, String value2, String value3) {
        if((!value1.isEmpty() && !value2.isEmpty()) || (!value2.isEmpty() && !value3.isEmpty()) || (!value1.isEmpty() && !value3.isEmpty())){
            return true;
        }
        else{
            return false;
        }
    }
}
