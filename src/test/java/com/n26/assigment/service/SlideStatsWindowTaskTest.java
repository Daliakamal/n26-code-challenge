package com.n26.assigment.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class SlideStatsWindowTaskTest {

	@Test
	public void testAddTransaction() {

		StatisticsProcessor statsProcessorMock = mock(StatisticsProcessor.class);

		new SlideStatsWindowTask(statsProcessorMock).run();

		verify(statsProcessorMock, times(1)).slidePerodicStatsicsWindow();

	}
}
