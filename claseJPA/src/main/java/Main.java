import dao.IDAO;
import dao.ImpDAO;
import model.Autor;
import model.Estudiante;

public class Main {

    public static void main(String [] args) {
       /* Autor a =  new Autor(1L,"Megan");
        IDAO dao = new ImpDAO();
        //Autor b = dao.findById(a.getId(),Autor.class);
        dao.create(a);
        System.out.println(dao.findAll(Autor.class,"Autor.all"));*/

        Estudiante a = new Estudiante(null,"Carlos","Cerda");
        IDAO dao = new ImpDAO();
        dao.create(a);
        System.out.println(dao.findAll(Estudiante.class,"Estudiante.all"));
    }
}
