/*
 * Copyright (c) 2013-2017 Chris Newland.
 * Licensed under https://github.com/AdoptOpenJDK/jitwatch/blob/master/LICENSE-BSD
 * Instructions: https://github.com/AdoptOpenJDK/jitwatch/wiki
 */
package org.adoptopenjdk.jitwatch.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SplitLog
{
	private List<NumberedLine> headerLines = new ArrayList<>();
	private List<NumberedLine> classLoaderLines = new ArrayList<>();
	private List<NumberedLine> compilationLines = new ArrayList<>();
	private List<NumberedLine> assemblyLines = new ArrayList<>();
	
	public void clear()
	{
		headerLines.clear();
		classLoaderLines.clear();
		compilationLines.clear();
		assemblyLines.clear();
	}
	
	public void addHeaderLine(NumberedLine line)
	{
		headerLines.add(line);
	}
	
	public void addClassLoaderLine(NumberedLine line)
	{
		classLoaderLines.add(line);
	}
	
	public void addCompilationLine(NumberedLine line)
	{
		compilationLines.add(line);
	}
	
	public void addAssemblyLine(NumberedLine line)
	{
		assemblyLines.add(line);
	}

	public List<NumberedLine> getHeaderLines()
	{
		return Collections.unmodifiableList(headerLines);
	}
	
	public List<NumberedLine> getClassLoaderLines()
	{
		return Collections.unmodifiableList(classLoaderLines);
	}
	
	public List<NumberedLine> getCompilationLines()
	{
		return Collections.unmodifiableList(compilationLines);
	}
	
	public List<NumberedLine> getAssemblyLines()
	{
		return Collections.unmodifiableList(assemblyLines);
	}
}