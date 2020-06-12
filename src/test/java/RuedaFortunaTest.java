import static org.junit.Assert.*;

import org.junit.*;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class RuedaFortunaTest {
    RuedaFortuna rueda;
    ByteArrayOutputStream newConsole; //Objeto que captura la salida por consola
    PrintStream previousConsole = System.out; //Objeto que almacena la referencia a la salida por consola

    @Before
    public void setUp() throws Exception {

        // Creamos un objeto consola, y le decimos que la salidas la seteamos a este objeto y asi capturar la salida por pantalla
        newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(previousConsole); //Una vez finalizado un test, se vuelve a "setear" la salida a la antigua consola
    }

    @Test
    public void inicializarRueda_test01() {
        RuedaFortuna rueda = new RuedaFortuna(); //Creamos un objeto consola
        rueda.inicializarRueda(-1); //Si el numero de casillas es negativo, debe saltar un mensaje de error
        String mensajeEsperado = "Error: el largo de las ruedas debe ser mayor o igual a 4 y menor o igual a 100\r\n";
        String mensajeReal = newConsole.toString(); //Capturamos el mensaje que salio en pantalla

        assertEquals(mensajeEsperado, mensajeReal); //Si el mensaje esperado es igual al real, entonces la prueba pasa
        //Los siguientes test repite el mismo procedimiento para distintos casos de numeros de casillas
    }

    @Test
    public void inicializarRueda_test02() {
        RuedaFortuna rueda = new RuedaFortuna();
        rueda.inicializarRueda(3); //Si el numero de casillas es menor que 4, debe salir en pantalla un error
        String mensajeEsperado = "Error: el largo de las ruedas debe ser mayor o igual a 4 y menor o igual a 100\r\n";
        String mensajeReal = newConsole.toString();


        assertEquals(mensajeEsperado, mensajeReal);
    }

    @Test
    public void inicializarRueda_test03() {
        RuedaFortuna rueda = new RuedaFortuna();
        rueda.inicializarRueda(101);
        String mensajeEsperado = "Error: el largo de las ruedas debe ser mayor o igual a 4 y menor o igual a 100\r\n";
        String mensajeReal = newConsole.toString();


        assertEquals(mensajeEsperado, mensajeReal);
    }

    @Test
    public void inicializarRueda_test04() {
        RuedaFortuna rueda = new RuedaFortuna();
        rueda.inicializarRueda(10);
        int cantidadDeCasillas = rueda.cantidadDeCasillas();
        int esperado = 10;
        //assertEquals(esperado,cantidadDeCasillas);
    }

    @Test
    public void lanzarRueda_test01() {
        RuedaFortuna rueda = new RuedaFortuna(); //Creamos un objeto rueda de tipo RuedaFortuna
        rueda.inicializarRueda(50); //esta rueda tendra 50 casillas
        int numero = rueda.lanzarRueda(); //obtenemos un valor en un casilla aleatoria
        boolean esperado = true;
        boolean real = (numero >= 1 && numero <= 100); //Si El numero que devuelve el metodo esta entre 1 y 100, el booleano real almacena un true
        assertEquals(esperado, real);

    }

    @Test
    public void lanzarRueda_test02() {
        RuedaFortuna rueda = new RuedaFortuna();
        //rueda.inicializarRueda(50);
        int numero = rueda.lanzarRueda(); //Como la rueda no se ha inicializado, el metodo retorna un -1 ya que casillas = null
        boolean esperado = false;
        boolean real = (numero >= 1 && numero <= 100); // -1 no esta dentro del rango, asique esta operacion logica nos dara un false
        assertEquals(esperado, real);

    }
}