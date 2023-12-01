package config;

public class GenerarSerie {
    int dato;
    String numero;
    
    public String NumeroSerie(int dato){
    this.dato=dato+1;
        if ((this.dato>=10000000)&&(this.dato<=100000000)) {
            numero=""+this.dato;
        }
        if ((this.dato>=1000000)&&(10000000>=this.dato)) {
            numero="00"+this.dato;
        }
        if ((this.dato>=100000)&&(1000000>=this.dato)) {
            numero="000"+this.dato;
        }
        if ((this.dato>=10000)&&(100000>=this.dato)) {
            numero="0000"+this.dato;
        }
        if ((this.dato>=1000)&&(10000>=this.dato)) {
            numero="00000"+this.dato;
        }
        if ((this.dato>=100)&&(1000>=this.dato)) {
            numero="000000"+this.dato;
        }
        if ((this.dato>=10)&&(this.dato<=100)) {
            numero="0000000"+this.dato;
        }
        if (10>this.dato) {
           numero="00000000"+this.dato;
        }
    return this.numero;
    }
}

