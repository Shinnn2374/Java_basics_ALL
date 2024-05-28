public class keyboardsettings {
    private final KEYBOARD.KEYBOARDTYPE keyboardtype;
    private final KEYBOARD.KEYBOARDGIDRAVLIK keyboardgidravlik;
    private final double keyboardweight;

    public keyboardsettings(KEYBOARD.KEYBOARDTYPE keyboardtype,
                            KEYBOARD.KEYBOARDGIDRAVLIK keyboardgidravlik,
                            double keyboardweight) {
        this.keyboardtype = keyboardtype;
        this.keyboardgidravlik = keyboardgidravlik;
        this.keyboardweight = keyboardweight;
    }

    public KEYBOARD.KEYBOARDTYPE getKeyboardtype() {
        return keyboardtype;
    }

    public KEYBOARD.KEYBOARDGIDRAVLIK getKeyboardgidravlik() {
        return keyboardgidravlik;
    }

    public double getKeyboardweight() {
        return keyboardweight;
    }

    public String toStringKeyboard(){
        return ("Тип клавиатуры - " + keyboardtype + "\n" +
                "Есть ли подвеска - " + keyboardgidravlik + "\n" +
                "Вес клавиатуры - " + keyboardweight);
    }
}
