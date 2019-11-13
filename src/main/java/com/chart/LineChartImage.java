package com.chart;
import java.awt.Color;
import java.io.*;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/* 
 * Author : Sandip Bhetariya
 * 
 * set custom y
 * */

public class LineChartImage {



	public static void main( String[ ] args ) throws Exception {
		try {
			DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
			line_chart_dataset.addValue(941, "", "1");
            line_chart_dataset.addValue(936, "", "2");
            line_chart_dataset.addValue(923, "", "3");
            line_chart_dataset.addValue(927, "", "4");
            line_chart_dataset.addValue(908, "", "5");
            line_chart_dataset.addValue(880, "", "6");
            line_chart_dataset.addValue(885, "", "7");
            line_chart_dataset.addValue(881, "", "8");
            line_chart_dataset.addValue(887, "", "9");
            line_chart_dataset.addValue(906, "", "10");
            line_chart_dataset.addValue(903, "", "11");
            line_chart_dataset.addValue(883, "", "12");




			JFreeChart lineChartObject = ChartFactory.createLineChart("Schools Vs Student", "Student", "Months",
					line_chart_dataset,PlotOrientation.VERTICAL, false, false, false);


			final CategoryPlot plot = lineChartObject.getCategoryPlot();
			final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
			rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
			rangeAxis.setRange(8000, 11000);

			// rotate X dates
			final CategoryAxis domainAxis = plot.getDomainAxis();
			domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

			// set bar colors
			final LineAndShapeRenderer line = (LineAndShapeRenderer) plot.getRenderer();
			line.setSeriesPaint(0, Color.BLUE);

			int width = 640;    /* Width of the image */
			int height = 480;   /* Height of the image */ 
			File lineChart = new File( "png_line_chart.png" ); 
			ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
			System.out.println("Successfully Create PNG Chart");

		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}

	}

}
