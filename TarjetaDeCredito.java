public class TarjetaDeCredito extends metodoDePago {
    private int cuotas;
    
    public TarjetaDeCredito(float dinero, int cuotas) {
        super(dinero);
        setCuotas(cuotas);
        setsubTotal(dinero);
        settotal(calculartotal());
    }

    @Override
    public float calculartotal() {
        Integer cuotas=getCuotas();
        float subtotal = getsubTotal();
        float recargo;
        switch (cuotas) {
            case 2:
                recargo=subtotal+0.06f;
                break;
            case 3:
                recargo=subtotal+0.12f;
                break;
            case 6:
                recargo=subtotal+0.20f;
                break;
            default:
                recargo=0;
                break;
        }
        return subtotal + recargo;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

 
}
