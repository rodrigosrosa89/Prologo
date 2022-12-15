package com.project.prologo.services;

import com.project.prologo.entities.CategoryEntity;
import com.project.prologo.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository repository;
    @InjectMocks
    CategoryService service;

    @Test
    void findsCategoriesBlank() {
        Pageable pageable = mock(Pageable.class);
        Page<CategoryEntity> page = getPage();
        when(repository.findAll(pageable)).thenReturn(page);

        Page<CategoryEntity> response = service.findsCategories(null, pageable);
        assertThat(response).isNotNull();
        assertThat(response.getSize()).isNotZero();

    }

    @Test
    void findsCategoriesNotBlank() {
        String category = "categoria";
        Pageable pageable = mock(Pageable.class);
        Page<CategoryEntity> page = getPage();
        when(repository.findCategoryLikedName(category, pageable)).thenReturn(page);

        Page<CategoryEntity> response = service.findsCategories(category, pageable);
        assertThat(response).isNotNull();
        assertThat(response.getSize()).isNotZero();
    }

    private Page<CategoryEntity> getPage() {
        return new Page<CategoryEntity>() {
            @Override
            public int getTotalPages() {
                return 1;
            }

            @Override
            public long getTotalElements() {
                return 1;
            }

            @Override
            public <U> Page<U> map(Function<? super CategoryEntity, ? extends U> converter) {
                return null;
            }

            @Override
            public int getNumber() {
                return 1;
            }

            @Override
            public int getSize() {
                return 1;
            }

            @Override
            public int getNumberOfElements() {
                return 0;
            }

            @Override
            public List<CategoryEntity> getContent() {
                return null;
            }

            @Override
            public boolean hasContent() {
                return false;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public boolean isFirst() {
                return false;
            }

            @Override
            public boolean isLast() {
                return false;
            }

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Pageable nextPageable() {
                return null;
            }

            @Override
            public Pageable previousPageable() {
                return null;
            }

            @Override
            public Iterator<CategoryEntity> iterator() {
                return new Iterator<CategoryEntity>() {
                    @Override
                    public boolean hasNext() {
                        return true;
                    }

                    @Override
                    public CategoryEntity next() {
                        return new CategoryEntity();
                    }
                };
            }
        };
    }


}
