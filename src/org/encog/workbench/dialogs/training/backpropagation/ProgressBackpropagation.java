package org.encog.workbench.dialogs.training.backpropagation;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.Date;

import javax.swing.JLabel;

import org.encog.neural.data.NeuralDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.Train;
import org.encog.neural.networks.training.backpropagation.Backpropagation;
import org.encog.workbench.dialogs.training.BasicTrainingProgress;
import org.encog.workbench.util.TimeSpanFormatter;

public class ProgressBackpropagation extends BasicTrainingProgress {
	
	private double learningRate;
	private double momentum;
		
	public ProgressBackpropagation(
			Frame owner,
			BasicNetwork network,
			NeuralDataSet trainingData,
			double learningRate,
			double momentum,
			double maxError)
	{
		super(owner);
		setTitle("Backpropagation Training");
		this.setNetwork( network );
		this.setTrainingData( trainingData );
		this.learningRate = learningRate;
		this.momentum = momentum;
		this.setMaxError( maxError);
        
	}

	@Override
	public void iteration() {

		this.getTrain().iteration();

	}

	@Override
	public void shutdown() {		
	}

	@Override
	public void startup() {
		Train train = new Backpropagation(
				this.getNetwork(), 
				this.getTrainingData(),
				this.learningRate, 
				this.momentum);	
		
		setTrain(train);
	}


}