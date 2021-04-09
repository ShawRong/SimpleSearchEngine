package hust.cs.javacourse.search.index.impl;

import java.util.List;

import hust.cs.javacourse.search.index.AbstractDocument;
import hust.cs.javacourse.search.index.AbstractTermTuple;

public class Document extends AbstractDocument{
	
	public Document() {
		super();
	}
	public Document(int docId, String docPath) {
		super(docId, docPath);
	}
	public Document(int docId, String docPath, List<AbstractTermTuple> tuples) {
		super(docId, docPath, tuples);
	}
	@Override
	public int getDocId() {
		return docId;
	}

	@Override
	public void setDocId(int docId) {
		this.docId = docId;
	}

	@Override
	public String getDocPath() {
		return docPath;
	}

	@Override
	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}

	@Override
	public List<AbstractTermTuple> getTuples() {
		return tuples;
	}

	@Override
	public void addTuple(AbstractTermTuple tuple) {
		if(!this.contains(tuple)) {
			this.tuples.add(tuple);
		}
	}

	@Override
	public boolean contains(AbstractTermTuple tuple) {
		boolean flag = false;
		if(this.tuples != null && this.tuples.contains(tuple)) {
			flag = true;
		}
		return flag;
	}

	@Override
	public AbstractTermTuple getTuple(int index) {
		return tuples == null ? null : tuples.get(index);
	}

	@Override
	public int getTupleSize() {
		return tuples.size();
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		for(AbstractTermTuple tuple : tuples) {
			str.append(tuple.toString() + " ");
		}
		return "docId:" + docId + "docPath:" + docPath + "tuples:" + str.toString();
	}
	
}
