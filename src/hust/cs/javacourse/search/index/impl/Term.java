package hust.cs.javacourse.search.index.impl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

import hust.cs.javacourse.search.index.AbstractTerm;

public class Term extends AbstractTerm {
	public Term() {
		
	}
	
	public Term(String content) {
		super(content);
	}
	
	@Override
	public void writeObject(ObjectOutputStream out) {
		try {
			out.writeObject(this.getContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readObject(ObjectInputStream in) {
		try {
			this.setContent((String) in.readObject());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		if(obj instanceof AbstractTerm) {
			if(this.content.equals(((AbstractTerm) obj).getContent())) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public String toString() {
		return this.content;
	}

	@Override
	public String getContent() {
		return this.content;
	}

	@Override
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int compareTo(AbstractTerm o) {
		return this.content.compareTo(o.getContent());
	}
	
}
