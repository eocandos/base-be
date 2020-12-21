package co.com.pt.vo.response;

import co.com.pt.entity.Project;
import org.springframework.data.domain.Page;

public class CategoryPage {
    private String category;
    private Page<Project> page;

    public CategoryPage(String category, Page<Project> page) {
        this.category = category;
        this.page = page;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Page<Project> getPage() {
        return page;
    }

    public void setPage(Page<Project> page) {
        this.page = page;
    }
}
