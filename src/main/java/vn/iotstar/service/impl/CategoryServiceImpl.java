package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.ICategoryDao;
import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
	public ICategoryDao cateDao = new CategoryDaoImpl();

	@Override
	public List<CategoryModel> findAll() {
		return cateDao.findAll();
	}

	@Override
	public CategoryModel findById(int id) {
		return cateDao.findById(id);
	}

	@Override
	public CategoryModel findByName(String name) {
		return cateDao.findByName(name);

	}

	@Override
	public void insert(CategoryModel category) {
		
			cateDao.insert(category);
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(category.getCategoryid());
		if (cate != null) {
			cateDao.update(category);
		}
	}

	@Override
	public void delete(int id) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(id);
		if (cate != null) {
			cateDao.delete(id);
		}
	}

	@Override
	public void updateStatus(int id, int status) {
		cateDao.updateStatus(id, status);

	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		return cateDao.findName(keyword);

	}

}
