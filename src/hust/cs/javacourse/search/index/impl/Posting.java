package hust.cs.javacourse.search.index.impl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;
import java.io.IOException;

import hust.cs.javacourse.search.index.AbstractPosting;

public class Posting extends AbstractPosting {
	public Posting() {
		
	}
	
	public Posting(int docId, int freq, List<Integer> positions) {
		super(docId, freq, positions);
	}
	
	@Override
	public void writeObject(ObjectOutputStream out) {
		try {
			out.writeObject(this.docId);
			out.writeObject(this.freq);
			out.writeObject(this.positions);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void readObject(ObjectInputStream in) {
		try {
			this.setDocId((Integer) in.readObject());
			this.setFreq((Integer) in.readObject());
			this.setPositions(((List<Integer>) in.readObject()));
		} catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		if(obj instanceof AbstractPosting) {
			if(this.docId == ((AbstractPosting) obj).getDocId()
			   && this.freq == ((AbstractPosting) obj).getFreq()
			   && this.positions.equals(((AbstractPosting) obj).getPositions())) 
			{
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public String toString() {
		return ("docId:" + this.docId + " " + "freq:" + this.freq + " " + "positions" + this.positions);
	}

	@Override
	public int getDocId() {
		return this.docId;
	}

	@Override
	public void setDocId(int docId) {
		this.docId = docId;
	}

	@Override
	public int getFreq() {
		return this.freq;
	}

	@Override
	public void setFreq(int freq) {
		this.freq = freq;
	}

	@Override
	public List<Integer> getPositions() {
		return this.positions;
	}

	@Override
	public void setPositions(List<Integer> positions) {
		this.positions = positions;
	}

	@Override
	public int compareTo(AbstractPosting o) {
		return this.docId - o.getDocId();
	}

	@Override
	public void sort() {
		Collections.sort(this.positions);
	}

}
