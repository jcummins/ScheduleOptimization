import javax.swing.*;

/*
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
*/

public class TestScheduler {

	public TestScheduler() {
		
		/*
		final XYSeries Sunday = new XYSeries("Sunday");
		final XYSeries Monday = new XYSeries("Monday");
		final XYSeries Tuesday = new XYSeries("Tuesday");
		final XYSeries Wednesday = new XYSeries("Wednesday");
		final XYSeries Thursday = new XYSeries("Thursday");
		final XYSeries Friday = new XYSeries("Friday");
		final XYSeries Saturday = new XYSeries("Saturday");
		Sunday.add(1.0, 105.0);
        Sunday.add(5.0, 110.0);
        Sunday.add(4.0, 120.0);
        Sunday.add(12, 110.0);
        Monday.add(1.0, 120.0);
        Monday.add(2.0, 110.0);
        Monday.add(5.0, 105.0);
        Monday.add(9.0, 110.0);
        Monday.add(12, 105.0);
        final XYSeriesCollection data = new XYSeriesCollection(Sunday);
        data.addSeries(Monday);
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "Meeting times by day",
            "Hour", 
            "Meetings", 
            data,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        final XYPlot plot = (XYPlot) chart.getPlot();
        final NumberAxis axis = (NumberAxis) plot.getRangeAxis();
        axis.setAutoRangeIncludesZero(false);
        axis.setAutoRangeMinimumSize(1.0);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        */
	}

	public static void main(String[] args) {
		
		Scheduler s1 = new Scheduler();
		Analyzer a1 = new Analyzer(s1);
		int[] hourF = a1.getHourFrequencies();
		for(int i=0;i<hourF.length;i++) {
			if(hourF[i]>0) {
				System.out.println("i:" + i + " hour: " +hourF[i]);
			}
		}
		JFrame frame = new JFrame("Grapher");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Grapher(a1));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		/*
		final TestScheduler demo = new TestScheduler("XY Series Demo 2");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
		*/

		
	}

}
