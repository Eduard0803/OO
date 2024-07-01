import javax.swing.JOptionPane;

class main{
    public static void main(String[] args){

        JOptionPane.showMessageDialog(null, "Input three numbers");
        float a = Float.parseFloat(JOptionPane.showInputDialog(null, null));
        float b = Float.parseFloat(JOptionPane.showInputDialog(null, null));
        float c = Float.parseFloat(JOptionPane.showInputDialog(null, null));

        JOptionPane.showMessageDialog(null, "Result = " + (a*a == (b*b + c*c)));
    }
}
