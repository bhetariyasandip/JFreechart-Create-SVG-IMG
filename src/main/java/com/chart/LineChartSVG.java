package com.chart;



import java.awt.geom.Rectangle2D;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
/* To create line chart object */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
/* To convert line chart as SVG */
import org.jfree.chart.plot.PlotOrientation;
/* To define the line chart data */
import org.jfree.data.category.DefaultCategoryDataset;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
/* 
 * Author : Sandip Bhetariya
 * */
public class LineChartSVG {  
	
     public static void main(String[] args){
        try {
                 /* Step - 1: Define the data for the line chart  */
                DefaultCategoryDataset svglineChartDataset = new DefaultCategoryDataset();
                svglineChartDataset.addValue(941, "", "1");
                svglineChartDataset.addValue(936, "", "2");
                svglineChartDataset.addValue(923, "", "3");
                svglineChartDataset.addValue(927, "", "4");
                svglineChartDataset.addValue(908, "", "5");
                svglineChartDataset.addValue(880, "", "6");
                svglineChartDataset.addValue(885, "", "7");
                svglineChartDataset.addValue(881, "", "8");
                svglineChartDataset.addValue(887, "", "9");
                svglineChartDataset.addValue(906, "", "10");
                svglineChartDataset.addValue(903, "", "11");
                svglineChartDataset.addValue(883, "", "12");
                
                
                
                /* Create line chart object - we can then convert to SVG */
                JFreeChart lineChartObject=ChartFactory.createLineChart("Schools Vs Student", "Student", "Months", svglineChartDataset, PlotOrientation.VERTICAL, false, false, false);
                /* Write Chart output as SVG */
                /* Get DOM Implementation */
                DOMImplementation mySVGDOM= GenericDOMImplementation.getDOMImplementation();
                /* create Document object */
                Document document = mySVGDOM.createDocument(null, "svg", null);
                /* Create SVG Generator */
                SVGGraphics2D my_svg_generator = new SVGGraphics2D(document);
                
                /* Render chart as SVG 2D Graphics object */
                lineChartObject.draw(my_svg_generator, new Rectangle2D.Double(0, 0, 640, 480), null);
                /* Write output to file */
                
                my_svg_generator.stream("svg_line_chart.svg"); 
                System.out.println("Successfully Create SVG Chart");
        }
        catch (Exception e)
        {
        	System.err.println(e);
			e.printStackTrace();
        }
    }
}

