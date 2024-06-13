public class debito extends metodoDePago{
        

    public debito(float dinero){
        super(dinero);
        setsubTotal(dinero);
        settotal(calculartotal());
    }

    @Override
    public float calculartotal() {
        
        float subtotal = getsubTotal();
        return subtotal +(subtotal * 0.10f);
    }
}

