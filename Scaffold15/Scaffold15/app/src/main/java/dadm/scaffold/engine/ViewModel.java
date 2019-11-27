package dadm.scaffold.engine;

public class ViewModel extends android.arch.lifecycle.ViewModel {


    private Integer nave;
    private Integer puntuacion;

    public ViewModel(){
        nave = 0;
        puntuacion = 0;
    }

    public void setNave(int a){
        nave = a;
    }

    public Integer getNave(){
        return nave;
    }

}
