/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Juan Suaza
 */
public class BarChart {
    
    static int ancho;
    static int alto;
    
    public BarChart(){
        ancho = 597;
        alto = 365;
    }
    
    public ChartPanel reporteEmpleados(DefaultCategoryDataset data){
        JFreeChart JFchart = ChartFactory.createBarChart("Reporte de empleados", "Sedes", "Cantidad", data, PlotOrientation.VERTICAL, true, true, true);
        /*
        CategoryPlot plot = new CategoryPlot();
        
        ChartFrame chartFrame = new ChartFrame("Reporte de empleadoos", JFchart, false);
        chartFrame.setSize(300, 300);
        chartFrame.setVisible(true);
        */
        ChartPanel panel = new ChartPanel(JFchart, true, true, true, false, false);
        
        panel.setSize(ancho, alto);
        
        return panel;
    }
    
    public ChartPanel reporteAportesVentas(DefaultCategoryDataset data){
        JFreeChart chart = ChartFactory.createBarChart("Reporte de aporte por sede", "Sedes", "Aporte", data, PlotOrientation.VERTICAL, true, true, true);
        
        ChartPanel panel = new ChartPanel(chart, true, true, true, false, false);
        panel.setSize(ancho, alto);
        
        return panel;
    }
    
    public ChartPanel reporteCantidadVehiculosPorSede(DefaultCategoryDataset data){
        JFreeChart chart = ChartFactory.createBarChart("Reporte de cantidad de vehiculos por sede", "Sedes", "Cantidad", data, PlotOrientation.VERTICAL, true, true, true);
        
        ChartPanel panel = new ChartPanel(chart, true, true, true, false, false);
        panel.setSize(ancho, alto);
        
        return panel;
    }
}
