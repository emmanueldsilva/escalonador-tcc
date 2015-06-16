/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador.tarefas;

/**
 *
 * @author Bill
 */
import java.util.Calendar;
import java.util.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.ui.ApplicationFrame;

public class DiagramaGantt extends ApplicationFrame {

    public DiagramaGantt(final String title, Periodo[] periodos) {

        super(title);

        final IntervalCategoryDataset dataset = createDataset(periodos);
        final JFreeChart chart = createChart(dataset);

        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(600, 700));
        setContentPane(chartPanel);

    }

    public static IntervalCategoryDataset createDataset(Periodo[] periodos) {
        
        int i=0;
        String str;
        long inicio,fim;
        final TaskSeries s1 = new TaskSeries("Tempo");
        
        while (i<periodos.length){
            str = Integer.toString(i);
            
            inicio = (long) (periodos[i].getInicio()*2.62974383*1000000000);
            fim = (long) (periodos[i].getFim()*2.62974383*1000000000);
            
            s1.add(new Task("Task ".concat(str),new SimpleTimePeriod(inicio,fim)));
            i++;
        }
        
        final TaskSeriesCollection collection = new TaskSeriesCollection();
        collection.add(s1);
        
        return collection;
    }

    /**
     * Utility method for creating <code>Date</code> objects.
     *
     * @param day  the date.
     * @param month  the month.
     * @param year  the year.
     *
     * @return a date.
     */
    private static Date date(final int day, final int month, final int year) {

        final Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        final Date result = calendar.getTime();
        return result;

    }
    
    /**
     * Creates a chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return The chart.
     */
    private JFreeChart createChart(final IntervalCategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createGanttChart(
            "Diagrama Gantt",  // chart title
            "Tarefa",              // domain axis label
            "Tempo",              // range axis label
            dataset,             // data
            false,                // include legend
            true,                // tooltips
            false                // urls
        );
        
//        chart.getCategoryPlot().getDomainAxis().setMaxCategoryLabelWidthRatio(10.0f);
        return chart;    
    }
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {
        /*
        final DiagramaGantt demo = new DiagramaGantt("Gantt Chart Demo 1",);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        */
    }

}