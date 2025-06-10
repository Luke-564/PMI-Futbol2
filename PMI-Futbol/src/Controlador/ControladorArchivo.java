package Controlador;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import Model.Jugadora;
import Model.Arbitro;

public class ControladorArchivo {
    
    File aj = new File("C:\\Users\\HP\\OneDrive\\OneDrive\\Escritorio\\Pala\\Maldita Perra Facultad\\2° Año\\Programación 2\\PMI-Futbol2\\PMI-Futbol\\src\\PMI-FutbolJugadoras.txt");
    File aa = new File("C:\\Users\\HP\\OneDrive\\OneDrive\\Escritorio\\Pala\\Maldita Perra Facultad\\2° Año\\Programación 2\\PMI-Futbol2\\PMI-Futbol\\src\\PMI-FutbolArbitros.txt");
    boolean fin = false;
    
    public void setAj(File aj) {
        this.aj = aj;
    }

    public void setAa(File aa) {
        this.aa = aa;
    }

    public File getAj() {
        return aj;
    }

    public File getAa() {
        return aa;
    }

    public ControladorArchivo() {
    }
    
public void incioMemoriaJugadoras(ArrayList<Jugadora> lista){ //Metodo que inicializa la lista de Jugadoras
    
      try {
        if (aj.createNewFile()) {
            System.out.println("Archivo creado.");
            return; // El archivo está vacío, no hay nada para leer aún
        } else {
            System.out.println("Archivo existente.");
        }
      }
      catch(IOException e){
          e.printStackTrace();
      }
    
    try(BufferedReader br = new BufferedReader(new FileReader(aj))) { //creo un buffer para leer renglones
      String reng; //string renglon axiliar
      while((reng=br.readLine())!=null){
        String[] atr=reng.split(","); // atr: Atrivutos jejejejojojojujuju
        if(atr.length==11){ 
            Jugadora jaux = new Jugadora();
            jaux.setNombre(atr[0]);
            jaux.setApellido(atr[1]);
            jaux.setNacimiento(Integer.parseInt(atr[2]),Integer.parseInt(atr[3]),Integer.parseInt(atr[4]));
            jaux.setDni(atr[5]);
            jaux.setNacionalidad(atr[6]);           /*hasta acá, el set de Persona*/
            jaux.setPosicion(atr[7]);
            jaux.setClub(atr[8]);
            jaux.setGoles(Integer.parseInt(atr[9]));
            jaux.setT_Amarillas(Integer.parseInt(atr[10]));
            jaux.setT_Rojas(Integer.parseInt(atr[11]));
            lista.add(jaux);
        }
      }
      br.close(); //Cuando el bloque de Try termina, el archivo se cierra solo, pero creo que no está de más
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void inicioMemoriaArbitros(ArrayList<Arbitro> lista){

    try {
        if (aa.createNewFile()) {
            System.out.println("Archivo creado.");
            return; // El archivo está vacío, no hay nada para leer aún
        } else {
            System.out.println("Archivo existente.");
        }
      }
      catch(IOException e){
          e.printStackTrace();
      }
    
    try(BufferedReader br = new BufferedReader(new FileReader(aa))){
    String reng;
    while((reng=br.readLine())!=null){
        String[] atr=reng.split(","); // atr: Atrivutos jejejejojojojujuju
        if(atr.length==8){
            Arbitro Aaux=new Arbitro();
            Aaux.setNombre(atr[0]);//nombre
            Aaux.setApellido(atr[1]);//apellido
            Aaux.setNacimiento(Integer.parseInt(atr[2]),Integer.parseInt(atr[3]),Integer.parseInt(atr[4])); //¿Como se vamos a guardar nacimiento? creo que deberiamos cambiar el toString para que guarde como dia,mes,año
            Aaux.setDni(atr[5]);                              /*hasta acá lo de persona*/
            Aaux.setNacionalidad(atr[6]);
            Aaux.setTarjetas(Integer.parseInt(atr[7]));
            if(atr[8].equals("true")){
                Aaux.setInternacional(true);
            }
            else if(atr[8].equals("false")){
                Aaux.setInternacional(false);
            }
            lista.add(Aaux);
        }
    }
    br.close(); //Cuando el bloque de Try termina, el archivo se cierra solo, pero creo que no está de más
}
catch(IOException e){
    e.printStackTrace();
}
}

public void guardarJuEnArchivo(ArrayList<Jugadora> ju){
try(BufferedReader br = new BufferedReader(new FileReader(aj))){
    String reng;
    while((reng=br.readLine())!=null){ 
        if(reng.isEmpty()){
            fin = true;
            break;
        }
    }
}
catch(IOException e){
    e.printStackTrace();
}
try (BufferedWriter bw = new BufferedWriter(new FileWriter(aj,true))){ // new FileWriter(aa,true) es abrir el achivo en modo apend
    if (fin = true){
    for (Jugadora p : ju) {
                bw.write(p.toString());
                bw.newLine(); // salto de línea
            }
}
}    
catch(IOException e){
    e.printStackTrace();
}
}

public void guardarArbEnArchivo(ArrayList<Arbitro> arr){
try(BufferedReader br = new BufferedReader(new FileReader(aa))){
    String reng;
    while((reng=br.readLine())!=null){ 
        if(reng.isEmpty()){
            fin = true;
            break;
        }
    }
}
catch(IOException e){
    e.printStackTrace();
}
try (BufferedWriter bw = new BufferedWriter(new FileWriter(aa,true))){ // new FileWriter(aa,true) es abrir el achivo en modo apend
    if (fin = true){
    for (Arbitro p : arr) {
                bw.write(p.toString());
                bw.newLine(); // salto de línea
            }
}
}    
catch(IOException e){
    e.printStackTrace();
}
}
}