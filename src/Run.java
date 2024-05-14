import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Run extends JFrame implements ActionListener {
    JComboBox algoSelect;
    String selectedAlgo;
    JPanel upperPanel = new JPanel();
    CreateArray createArray = new CreateArray();
    int[] array = createArray.generateArray();
    Draw draw = new Draw(array);

    JButton start;
    JButton reset;
    boolean needReset = false;

    BubbleSort bubbleSort = new BubbleSort();
    QuickSort quickSort = new QuickSort();

    JLabel runTimeLabel;
    JLabel comparisonsLabel;
    JLabel swapsLabel;

    public static int noComparisons = 0;
    public static int noSwaps = 0;

    public Run(){
        this.setTitle("Sorting algorithms visualizer");
        this.setSize(new Dimension(870, 622));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        runTimeLabel = new JLabel("Runtime = null");
        runTimeLabel.setBounds(10,10,200,30);
        runTimeLabel.setForeground(Color.BLACK);
        upperPanel.add(runTimeLabel);

        comparisonsLabel = new JLabel("No. of comparisons: "+ noComparisons);
        comparisonsLabel.setBounds(10,40,200,30);
        comparisonsLabel.setForeground(Color.BLACK);
        upperPanel.add(comparisonsLabel);

        swapsLabel = new JLabel("No. of swaps: " + noSwaps);
        swapsLabel.setBounds(10,70,200,30);
        swapsLabel.setForeground(Color.BLACK);
        upperPanel.add(swapsLabel);

        String[] algorithms = {"Select algorithm","Bubble sort","Quick sort"};
        algoSelect = new JComboBox<>(algorithms);
        algoSelect.setBounds(690,0,155,30);
        algoSelect.addActionListener(this);
        upperPanel.add(algoSelect);

        start = new JButton("Start");
        start.setBounds(700, 30, 140,30);
        start.addActionListener(this);
        upperPanel.add(start);

        reset = new JButton("Reset");
        reset.setBounds(700, 60, 140, 30);
        reset.addActionListener(this);
        upperPanel.add(reset);

        upperPanel.setBounds(0,0,870,100);
        draw.setBounds(0,100,870,522);

        upperPanel.setLayout(new BorderLayout());
        this.add(draw);
        this.add(upperPanel);
        this.validate();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==start && algoSelect.getSelectedItem() != "Select algorithm" && !needReset){
            if (selectedAlgo.equals("Bubble")){
                try{
                    bubbleSort.executeBubbleSort(array, draw, this);
                } catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            } else if (selectedAlgo.equals("Quick")) {
                try{
                    quickSort.executeQuickSort(array,draw,this);
                } catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        }

        if (e.getSource()==algoSelect){
            if (algoSelect.getSelectedItem() == "Bubble sort"){
                selectedAlgo = "Bubble";
                runTimeLabel.setText("Runtime: O(N^2)");
            } else if (algoSelect.getSelectedItem()=="Quick sort") {
                selectedAlgo = "Quick";
                runTimeLabel.setText("Runtime: Nlog(N)");
            }
        }

        if (e.getSource()==reset){
            noSwaps = 0;
            noComparisons = 0;
            swapsLabel.setText("No. of swaps: " + noSwaps);
            comparisonsLabel.setText("No. of comparisons: "+ noComparisons);

            array = createArray.generateArray();
            draw.updateArray(array);
            draw.repaint();
            needReset = false;
        }
        if (needReset){
            swapsLabel.setText("No. of swaps: " + noSwaps);
            comparisonsLabel.setText("No. of comparisons: "+ noComparisons);
        }
    }
}
