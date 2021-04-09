package hust.cs.javacourse.search.index.impl;

import java.io.File;

import hust.cs.javacourse.search.index.AbstractDocument;
import hust.cs.javacourse.search.index.AbstractDocumentBuilder;
import hust.cs.javacourse.search.parse.AbstractTermTupleStream;

public class DocumentBuilder extends AbstractDocumentBuilder{

	@Override
	public AbstractDocument build(int docId, String docPath, AbstractTermTupleStream termTupleStream) {
		
	}

	@Override
	public AbstractDocument build(int docId, String docPath, File file) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
