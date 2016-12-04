/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Juan Suaza
 */
public class BarChart {
    
    static int ancho;
    static int alto;
    
    public BarChart(){
        ancho = 780;
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
        
        CategoryPlot categoryP = JFchart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) categoryP.getRenderer();
        renderer.setMaximumBarWidth(0.35);
        Color color = new Color(67,165,208);
        renderer.setSeriesPaint(0, color);
        
        ChartPanel panel = new ChartPanel(JFchart, true, true, true, false, false);
        
        panel.setSize(ancho, alto);
        
        return panel;
    }
    
    public ChartPanel reporteAportesVentas(DefaultCategoryDataset data){
        JFreeChart chart = ChartFactory.createBarChart("Reporte de aporte por sede", "Sedes", "Aporte", data, PlotOrientation.VERTICAL, true, true, true);
        
        CategoryPlot categoryP = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) categoryP.getRenderer();
        renderer.setMaximumBarWidth(0.35);
        Color color = new Color(67,165,208);
        renderer.setSeriesPaint(0, color);
        
        ChartPanel panel = new ChartPanel(chart, true, true, true, false, false);
        panel.setSize(ancho, alto);
        
        return panel;
    }
    
    public ChartPanel reporteCantidadVehiculosPorSede(DefaultCategoryDataset data){
        JFreeChart chart = ChartFactory.createBarChart("Reporte de cantidad de vehiculos por sede", "Sedes", "Cantidad", data, PlotOrientation.VERTICAL, true, true, true);
        
        CategoryPlot categoryP = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) categoryP.getRenderer();
        renderer.setMaximumBarWidth(0.35);
        Color color = new Color(67,165,208);
        renderer.setSeriesPaint(0, color);
        
        ChartPanel panel = new ChartPanel(chart, true, true, true, false, false);
        panel.setSize(ancho, alto);
        
        return panel;
    }
    
    public ChartPanel reporteCantidadCotizacionesSede(DefaultCategoryDataset data){
        JFreeChart chart = ChartFactory.createBarChart("Reporte de cantidad de cotizaciones por empleado", "Empleado", "Cantidad", data, PlotOrientation.VERTICAL, true, true, true);
        
        CategoryPlot categoryP = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) categoryP.getRenderer();
        renderer.setMaximumBarWidth(0.35);
        Color color = new Color(67,165,208);
        renderer.setSeriesPaint(0, color);
        
        ChartPanel panel = new ChartPanel(chart, true, true, true, false, false);
        panel.setSize(ancho, alto);
        
        return panel;
    }
    
    public ChartPanel reporteCantidadCotizacionesEmpresa(DefaultCategoryDataset data){
        JFreeChart chart = ChartFactory.createBarChart("Reporte de cantidad de cotizaciones por sede", "Sede", "Cantidad", data, PlotOrientation.VERTICAL, true, true, true);
        
        CategoryPlot categoryP = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) categoryP.getRenderer();
        renderer.setMaximumBarWidth(0.35);
        Color color = new Color(67,165,208);
        renderer.setSeriesPaint(0, color);
        
        ChartPanel panel = new ChartPanel(chart, true, true, true, false, false);
        panel.setSize(ancho, alto);
        
        return panel;
    }
    
    public ChartPanel reporteVehiculosAgregados(DefaultCategoryDataset data){
        JFreeChart chart = ChartFactory.createBarChart("Reporte de cantidad de vehiculos añadidos por sede", "Sedes", "Cantidad", data, PlotOrientation.VERTICAL, true, true, true);
        
        CategoryPlot categoryP = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) categoryP.getRenderer();
        renderer.setMaximumBarWidth(0.35);
        Color color = new Color(67,165,208);
        renderer.setSeriesPaint(0, color);
        
        ChartPanel panel = new ChartPanel(chart, true, true, true, false, false);
        panel.setSize(ancho, alto);
        
        return panel;
    }
    
    public ChartPanel reporteOrdenesEmpresa(DefaultCategoryDataset data){
        JFreeChart chart = ChartFactory.createBarChart("Reporte de ordenes de trabajo por sede", "Sedes", "Cantidad", data, PlotOrientation.VERTICAL, true, true, true);
        
        CategoryPlot categoryP = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) categoryP.getRenderer();
        renderer.setMaximumBarWidth(0.35);
        Color color = new Color(67,165,208);
        renderer.setSeriesPaint(0, color);
        
        ChartPanel panel = new ChartPanel(chart, true, true, true, false, false);
        panel.setSize(ancho, alto);
        
        return panel;
    }
    
    public ChartPanel reporteOrdenesSede(DefaultCategoryDataset data){
        JFreeChart chart = ChartFactory.createBarChart("Reporte de ordenes de trabajo por jefe", "Jefe de taller", "Cantidad", data, PlotOrientation.VERTICAL, true, true, true);
        
        CategoryPlot categoryP = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) categoryP.getRenderer();
        renderer.setMaximumBarWidth(0.35);
        Color color = new Color(67,165,208);
        renderer.setSeriesPaint(0, color);
        
        ChartPanel panel = new ChartPanel(chart, true, true, true, false, false);
        panel.setSize(ancho, alto);
        
        return panel;
    }
    
    public ChartPanel reporteVentasEmpresa(DefaultCategoryDataset data){
        JFreeChart chart = ChartFactory.createBarChart("Reporte de ventas por sede", "Sede", "Cantidad", data, PlotOrientation.VERTICAL, true, true, true);
        
        CategoryPlot categoryP = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) categoryP.getRenderer();
        renderer.setMaximumBarWidth(0.35);
        Color color = new Color(67,165,208);
        renderer.setSeriesPaint(0, color);
        
        ChartPanel panel = new ChartPanel(chart, true, true, true, false, false);
        panel.setSize(ancho, alto);
        
        return panel;
    }
    
    public ChartPanel reporteVentasSede(DefaultCategoryDataset data){
        JFreeChart chart = ChartFactory.createBarChart("Reporte de ventas por usuario", "Vendedor", "Cantidad", data, PlotOrientation.VERTICAL, true, true, true);
        
        CategoryPlot categoryP = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) categoryP.getRenderer();
        renderer.setMaximumBarWidth(0.35);
        Color color = new Color(67,165,208);
        renderer.setSeriesPaint(0, color);
        
        ChartPanel panel = new ChartPanel(chart, true, true, true, false, false);
        panel.setSize(ancho, alto);
        
        return panel;
    }
}

