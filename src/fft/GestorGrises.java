/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fft;

import espacial.Convolucion;
import java.awt.Color;
import java.awt.image.BufferedImage;


/**
 *
 * @author koke
 */
public class GestorGrises{

    private BufferedImage imagenOriginal;
    //public Map<HerramientasColor.CanalColor, NumeroComplejo[][]> representacionEspacial;
    public NumeroComplejo[][] representacionEspacial;
    public NumeroComplejo[][] representacionFrecuencias;
   // public Map<HerramientasColor.CanalColor, NumeroComplejo[][]> representacionFrecuencias;

    public GestorGrises(BufferedImage imagenOriginal) {
        this.imagenOriginal = imagenOriginal;
//        this.representacionEspacial = new HashMap<HerramientasColor.CanalColor, NumeroComplejo[][]>();
//        this.representacionFrecuencias = new HashMap<HerramientasColor.CanalColor, NumeroComplejo[][]>();
           this.representacionEspacial = obtenerDatos(imagenOriginal);
//        for (HerramientasColor.CanalColor color : HerramientasColor.CanalColor.values()) {
//            representacionEspacial.put(color, obtenerDatosPorCanal(imagenOriginal, color));
//        }

    }

    private NumeroComplejo[][] obtenerDatos(BufferedImage imagenOriginal) {
        NumeroComplejo[][] aux = new NumeroComplejo[imagenOriginal.getWidth()][imagenOriginal.getHeight()];
        // obtenemos los datos por canal
        Color color;
        for (int y = 0; y < imagenOriginal.getHeight(); y++) {
            for (int x = 0; x < imagenOriginal.getWidth(); x++) {
                color = new Color(imagenOriginal.getRGB(x, y));
                aux[x][y] = new NumeroComplejo(color.getBlue(), 0);
            }
        }
        return aux;
    }

//    public void aplicarFiltro(NumeroComplejo[][] filtro) {
//
//        // recorrer el filtro 
//        for (int x = 0; x < this.imagenOriginal.getWidth(); x++) {
//            for (int y = 0; y < this.imagenOriginal.getHeight();y++) {
//                // obtener el color el RGB de la parte de frecuencias
//                if (filtro[x][y].getParteReal()<1){
//                int rgb = obtenerPixelDominioFrecuencias(x,y,true);
//                Color aux = new Color(rgb);
//                int r = (int) (aux.getRed() * filtro[x][y].getParteReal());
//                int g = (int) (aux.getGreen()* filtro[x][y].getParteReal());
//                int b = (int) (aux.getBlue() * filtro[x][y].getParteReal());
//                aux = new Color(r, g, b);
//                setPixelDominioFrecuencias(x,y,true,aux.getRGB());}
//            }
//        }
//
//    }

    public BufferedImage obtenerImagenFrecuencias(boolean reAjustarCuadrante) {
        /// obtenemos las dimensiones
        int anchoImagen = this.imagenOriginal.getWidth();
        int altoImagen = this.imagenOriginal.getHeight();
        BufferedImage aux = new BufferedImage(anchoImagen, altoImagen, BufferedImage.TYPE_INT_ARGB);

        FFTCalculo fft = new FFTCalculo();
        // construir el mapeo de representacion en frecuencias utilizando FFT

        
            NumeroComplejo[][] datos = this.representacionEspacial;
            NumeroComplejo[][] transformada = fft.calculateFT(datos, false);
            this.representacionFrecuencias = transformada;
            // crear la imagen del espectro 
            for (int y = 0; y < aux.getHeight(); y++) {
                for (int x = 0; x < aux.getWidth(); x++) {
                    // modificamos la posicion de los cuadrantes 
                    int ejeX = reAjustarCuadrante ? (x + (anchoImagen / 2)) % anchoImagen : x;
                    int ejeY = reAjustarCuadrante ? (y + (altoImagen / 2)) % altoImagen : y;
                    // setear la info a la imagen 
                    // el que se ecuentre en la imagen 
                    int color1 = aux.getRGB(x, y);
                    int color2 = obtenerColorRealDeFrecuencia(ejeX, ejeY, transformada);
                    int rgb = HerramientasColor.acumularColor(color1, color2);
                    aux.setRGB(x, y, rgb);

                }
            }
        
        return aux;
    }

    public BufferedImage obtenerImagenEspacial() {
        /// obtenemos las dimensiones
        int anchoImagen = this.imagenOriginal.getWidth();
        int altoImagen = this.imagenOriginal.getHeight();
        BufferedImage aux = new BufferedImage(anchoImagen, altoImagen, BufferedImage.TYPE_INT_ARGB);

        FFTCalculo fft = new FFTCalculo();
        // construir el mapeo de representacion en frecuencias utilizando FFT

        
            NumeroComplejo[][] datos = this.representacionFrecuencias;
            NumeroComplejo[][] transformadaInv = fft.calculateFT(datos, true);
           // representacionEspacial.put(canal, transformadaInv);
            this.representacionEspacial = transformadaInv;
            // crear la imagen del espectro 
            for (int y = 0; y < aux.getHeight(); y++) {
                for (int x = 0; x < aux.getWidth(); x++) {

                    int color = (int) Math.abs(transformadaInv[x][y].getParteReal());
                    color = Convolucion.verificar(color);
                    color = new Color(color,color,color).getRGB();

                    int rgb = HerramientasColor.acumularColor(aux.getRGB(x, y), color);
                    aux.setRGB(x, y, rgb);
                }
            }
        
        return aux;

    }

    private int obtenerColorRealDeFrecuencia(int ejeX, int ejeY, NumeroComplejo[][] transformada) {
        int color = (int) Math.abs(transformada[ejeX][ejeY].getParteReal());
        color = Convolucion.verificar(color);
        color = new Color(color,color,color).getRGB();
        return color;
    }

//    private int obtenerPixelDominioFrecuencias(int x, int y, boolean encuadre) {
//        /// obtenemos las dimensiones
//        int anchoImagen = this.imagenOriginal.getWidth();
//        int altoImagen = this.imagenOriginal.getHeight();
//        // modificamos la posicion de los cuadrantes 
//        int ejeX = encuadre ? (x + (anchoImagen / 2)) % anchoImagen : x;
//        int ejeY = encuadre ? (y + (altoImagen / 2)) % altoImagen : y;
//        
//        // acumulamos 
//        int valorColor = 0;
//        for (HerramientasColor.CanalColor canal: HerramientasColor.CanalColor.values()){
//        NumeroComplejo[][] aux = representacionFrecuencias.get(canal);
//        valorColor += obtenerColorRealDeFrecuencia(ejeX, ejeY,aux, canal);
//        }
//        
//        return valorColor;
//    }

    private void setPixelDominioFrecuencias(int x, int y, boolean encuadre, int color) {
         /// obtenemos las dimensiones
        int anchoImagen = this.imagenOriginal.getWidth();
        int altoImagen = this.imagenOriginal.getHeight();
        // modificamos la posicion de los cuadrantes 
        int ejeX = encuadre ? (x + (anchoImagen / 2)) % anchoImagen : x;
        int ejeY = encuadre ? (y + (altoImagen / 2)) % altoImagen : y;
        
        // recorrer por canal de color 
        for (HerramientasColor.CanalColor canal: HerramientasColor.CanalColor.values()){
        NumeroComplejo[][] datos = this.representacionFrecuencias;
        int nuevo =  HerramientasColor.obtenerValorPorCanal(color, canal);
        
        datos[ejeX][ejeY] = new NumeroComplejo(nuevo,nuevo);
        
        }
        
    }
}
