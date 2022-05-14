import java.io.Serializable;

class Food implements Serializable
{
    private int code;
    private int quantity;
    private float price;

    Food(int code,int quantity)
    {
        this.code=code;
        this.quantity=quantity;
        switch(code)
        {
            case 1:price=quantity*50;
                break;
            case 2:price=quantity*60;
                break;
            case 3:price=quantity*70;
                break;
            case 4:price=quantity*30;
                break;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int item_no) {
        this.code = item_no;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}