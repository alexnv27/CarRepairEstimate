/*****
 * Alex Vasile 
 * <h3>JoesAutomotive</h3>
 * 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.*;

public class JoesAutomotive extends JFrame implements ActionListener
{
    private JPanel panelNorth, selectionPanel, panelSouth;

    private JLabel title, lblDisplay, selection, finalPrice, lblImage;

    private JTextField txtHoursWorked;

    private JButton calculate;

    private static JRadioButton oc, lj, rf, tf, i, mr, tr;

    private static int hours;
    
    /**
     * Constructor for class that sets titles and makes new layout
     **/

    public JoesAutomotive()
    {
        setTitle("Joes Automitve Program");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// user must click quit

        // set Layout manager for the JFrame
        setLayout(new BorderLayout());

        createInterface();
        pack();

        setVisible(true);

    }
    /**
     * Creates all the pannels and adds buttons/featuers to them
     **/
    public void createInterface()
    {
        setLayout(new BorderLayout());

        panelNorth = new JPanel();
        panelNorth.setLayout(new GridLayout(2, 1));

        title = new JLabel("Joe's Automotive Price Calculator");

        panelNorth.add(title);
        lblImage = new JLabel();

        lblImage.setIcon(new ImageIcon("car.jpg"));
        panelNorth.add(lblImage);

        lblDisplay = new JLabel("Optional: Please enter the numbers of hours Joe worked for other nonroutine services");
        panelNorth.add(lblDisplay);

        txtHoursWorked = new JTextField(1);
        panelNorth.add(txtHoursWorked);

        selectionPanel = new JPanel();
        selectionPanel.setLayout(new GridLayout(4, 1));

        selection = new JLabel("Select what Joe did");
        selectionPanel.add(selection);

        oc = new JRadioButton("Oil change");
        lj = new JRadioButton("Lube job");
        rf = new JRadioButton("Radiator flush");
        tf = new JRadioButton("Transmission flush");
        i = new JRadioButton("Inspection");
        mr = new JRadioButton("Muffler replacement");
        tr = new JRadioButton("Tire rotation");

        selectionPanel.add(oc);
        selectionPanel.add(lj);
        selectionPanel.add(rf);
        selectionPanel.add(tf);
        selectionPanel.add(i);
        selectionPanel.add(mr);
        selectionPanel.add(tr);

        panelSouth = new JPanel();
        panelSouth.setLayout(new GridLayout(4, 1));

        calculate = new JButton("calculate");
        calculate.addActionListener(this);

        panelSouth.add(calculate);

        add(panelNorth, BorderLayout.NORTH);
        add(selectionPanel, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);

    }
    /**
     * Typical actionPerformed method that calls the calculate method if the calculate button is pressed
     **/
    @Override
    public void actionPerformed(ActionEvent e)
    {

        String hrs = txtHoursWorked.getText();

        if (hrs.isBlank())
        {
            hours = 0;

        }

        try
        {
            hours = Integer.parseInt(hrs);
        } catch (NumberFormatException ex)
        {
            lblDisplay.setText("Error-wrong type entered");
        }
        lblDisplay.setText("Joe worked for you for " + hours + " hours");
        
        calculatePrice();//calculates price

        double t = calculatePrice();
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        finalPrice = new JLabel("Final Total: " + df.format(t));

        panelSouth.add(finalPrice);

        pack();

    }
    /**
     * Calculates price based on instructions 
     * @return total-final price to pay
     **/
    public static double calculatePrice()
    {
        double total = 0;
        total += hours * 20;

        if (oc.isSelected())
        {
            total += 26;
        }
        if (lj.isSelected())
        {
            total += 18;
        }
        if (rf.isSelected())
        {
            total += 30;
        }
        if (tf.isSelected())
        {
            total += 80;
        }
        if (i.isSelected())
        {
            total += 15;
        }
        if (mr.isSelected())
        {
            total += 100;
        }
        if (tr.isSelected())
        {
            total += 20;
        }
        return total;

    }

    /**
     * main method that makes new object to run application
     **/
    public static void main(String[] args)
    {
        JoesAutomotive joe = new JoesAutomotive();

    }
}
