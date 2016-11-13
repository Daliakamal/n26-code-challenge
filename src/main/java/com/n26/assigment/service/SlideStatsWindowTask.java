package com.n26.assigment.service;

import java.util.TimerTask;

/**
 * Scheduled job that run to check if we need to remove statistics from the current window
 * @author Dalia.Kamal
 *
 */
public class SlideStatsWindowTask extends TimerTask{

	private StatisticsProcessor processor;
	
	public SlideStatsWindowTask(StatisticsProcessor processor){
		this.processor = processor;
	}
	
	@Override
	public void run() {
		processor.slidePerodicStatsicsWindow();
	}
		
}
