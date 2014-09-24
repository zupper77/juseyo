package com.juseyo.commons.lib.messages;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import org.springframework.core.io.ResourceLoader;
 
public interface MessageService {

	public boolean getBoolean(String name) throws Exception;
	public boolean getBoolean(String name, boolean def) throws Exception;
	public double getDouble(String name) throws Exception;
	public double getDouble(String name, double def) throws Exception;
	public float getFloat(String name) throws Exception;
	public float getFloat(String name, float def) throws Exception;
	public int getInt(String name) throws Exception;
	public int getInt(String name, int def) throws Exception;
	public Iterator<?> getKeys() throws Exception;
	public Iterator<?> getKeys(String prefix) throws Exception;
	public long getLong(String name) throws Exception;
	public long getLong(String name, long def) throws Exception;
	public String getString(String name) throws Exception;
	public String getString(String name, String def) throws Exception;
	public String[] getStringArray(String name) throws Exception;
	public Vector<?> getVector(String name) throws Exception;
	public Vector<?> getVector(String name, Vector<?> def) throws Exception;
	public void refreshPropertyFiles() throws Exception;
	public Collection<?> getAllKeyValue() throws Exception;
}
