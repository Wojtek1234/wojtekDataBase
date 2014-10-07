package model;

import model.entity.Category;
import model.entity.base.Base;

import java.util.List;

/**
 * Created by w.maciejewski on 2014-10-07.
 */
public class CreateArrayOfCatNames
{
	private String[] strings;
	public CreateArrayOfCatNames( List<Category> entitys ){
		strings=createArrayOfNames(entitys);
	}

	public void updateNames(List<Category> entitys){
		this.strings=createArrayOfNames(entitys);
	}

	private String[] createArrayOfNames(List<Category> cat){
		String[]  cats=new String[cat.size()];
		int pom=0;
		for(Base category:cat){
			cats[pom]=category.getName();
			pom++;
		}
		return cats;
	}

	public String[] getStrings()
	{
		return strings;
	}
}
