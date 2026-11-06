/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jfree.starter;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Simple line chart with JFreeChart and Java Swing.
 *
 * @author Cesardl
 */
public class App extends JFrame {

    /**
     * Creates a new instance of the app.
     *
     * @param title the frame title.
     */
    public App(String title) {
        setTitle(title);
        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(1024, 360));
        setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Creates a sample dataset (hard-coded for the purpose of keeping the demo
     * self-contained - in practice you would normally read your data from a
     * file, database or other source).
     *
     * @return A sample dataset.
     */
    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
// data from Java in a Nutshell
        dataset.addValue(212, "Classes", "JDK 1.0");
        dataset.addValue(504, "Classes", "JDK 1.1");
        dataset.addValue(1520, "Classes", "JDK 1.2");
        dataset.addValue(1842, "Classes", "JDK 1.3");
        dataset.addValue(2991, "Classes", "JDK 1.4");
        dataset.addValue(3500, "Classes", "JDK 1.5");
// from https://stackoverflow.com/questions/3112882/how-many-classes-are-there-in-java-standard-edition
        dataset.addValue(3793, "Classes", "JDK 1.6");
        dataset.addValue(4024, "Classes", "JDK 1.7");
        dataset.addValue(4240, "Classes", "JDK 8");
        dataset.addValue(6005, "Classes", "JDK 9");
        dataset.addValue(6002, "Classes", "JDK 10");
        dataset.addValue(4411, "Classes", "JDK 11");
        dataset.addValue(4433, "Classes", "JDK 12");
        dataset.addValue(4545, "Classes", "JDK 13");
        dataset.addValue(4569, "Classes", "JDK 14");
        return dataset;
    }

    /**
     * Creates a sample chart.
     *
     * @param dataset a dataset.
     *
     * @return The chart.
     */
    private JFreeChart createChart(CategoryDataset dataset) {
// create the chart...
        JFreeChart chart = ChartFactory.createLineChart(
                "Java Standard Class Library", // chart title
                null, // domain axis label
                "Class Count", // range axis label
                dataset);
        chart.removeLegend();
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setRangePannable(true);
        plot.setRangeGridlinesVisible(false);
// customise the range axis...
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        ChartUtils.applyCurrentTheme(chart);
        chart.addSubtitle(new TextTitle("Number of Classes By Release"));
        TextTitle source = new TextTitle(
                "Sources: https://stackoverflow.com/q/3112882 "
                + "and Java In A Nutshell (5th Edition) by David Flanagan (O'Reilly)");
        source.setFont(new Font("SansSerif", Font.PLAIN, 10));
        source.setPosition(RectangleEdge.BOTTOM);
        source.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        chart.addSubtitle(source);
// customise the renderer...
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setDefaultShapesVisible(true);
        renderer.setDrawOutlines(true);
        renderer.setUseFillPaint(true);
        renderer.setDefaultFillPaint(Color.WHITE);
        renderer.setSeriesStroke(0, new BasicStroke(3.0f));
        renderer.setSeriesOutlineStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesShape(0, new Ellipse2D.Double(-5.0, -5.0, 10.0, 10.0));
        return chart;
    }

    /**
     * Entry point for the app.
     *
     * @param args these are ignored here.
     */
    public static void main(String[] args) {
        App app = new App("JFreeChart Starter App");
        app.pack();
        app.setVisible(true);
    }
}
