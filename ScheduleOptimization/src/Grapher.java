import java.awt.*;
import java.text.DecimalFormat;

import javax.swing.*;

public class Grapher extends JPanel {

	public Analyzer analyzer;
	
	public Grapher(Analyzer analyzer) 
	{
		this.analyzer=analyzer;
		
		setLayout(new BorderLayout(0,0));
		
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(0,8,0,0));
		
		/* Loop through the 9 outer squares */
		for (int k = 1; k <= 8; k++)
		{
			/* Setup this level */
			JPanel level2 = new JPanel();
			level2.setLayout(new GridLayout(25,0,0,0));
			
			/* Loop through the 9 inner squares */
			for (int i = 1; i <= 25; i++)
			{
				JPanel level3 = new JPanel();

				if(i>1 && k==1) {
					/* Y-Labels */
					level3.setBackground(Color.LIGHT_GRAY);
					level3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.DARK_GRAY));
					level3.add(new JLabel(Integer.toString(i-2)));
				} else {
					if(i==1) {
						/* X-labels */
						level3.setBackground(Color.LIGHT_GRAY);
						level3.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.DARK_GRAY));
						WeekSchedule sched = new WeekSchedule();
						if(k>1) {
							level3.add(new JLabel(sched.dayIndexToDay.get(Integer.toString(k-2))));
						}
						
					} else {
						/* Cells */
						level3.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 1, Color.white));
						int q=(i-2)+(k-2)*24;
						double r = (analyzer.getHourFrequencies()[q] / (double)analyzer.getTotalMinutes())*100;
						
						DecimalFormat df=new DecimalFormat("0.00");
						double roundr = new Double(df.format(r)).doubleValue();
						
						level3.add(new JLabel(Double.toString(roundr)));
					}
	
				}
				
				level2.add(level3);
			}
			
			gridPanel.add(level2);
		}
		
		add(gridPanel, BorderLayout.CENTER);
		
		setPreferredSize(new Dimension(800,600));
	}	
	
}
