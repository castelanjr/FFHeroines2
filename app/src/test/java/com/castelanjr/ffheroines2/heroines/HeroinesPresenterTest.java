package com.castelanjr.ffheroines2.heroines;

import com.castelanjr.ffheroines2.data.DataManager;
import com.castelanjr.ffheroines2.data.model.Heroine;
import com.castelanjr.ffheroines2.util.TestAppScheduler;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

public class HeroinesPresenterTest {

    @Mock
    DataManager dataManager;

    @Mock
    HeroinesView view;

    private HeroinesPresenter presenter;

    private List<Heroine> data;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        presenter = new HeroinesPresenter(dataManager, new TestAppScheduler());
        presenter.takeView(view);

        data = new ArrayList<>();
        data.add(Heroine.create(1L, "Terra", "Terra branford", "ability", "avatar", "image",
                "description", "color", "VI", "url"));
        data.add(Heroine.create(2L, "Lightning", "Claire Farron", "ability", "avatar", "image",
                "description", "color", "XIII", "url"));
    }

    @Test
    public void shouldLoadDataAndShowIntoView() {
        when(dataManager.heroines()).thenReturn(Single.just(data));

        presenter.loadHeroines();

        verify(view).showProgressIndicator(true);
        verify(dataManager).heroines();

        verify(view).showProgressIndicator(false);
        verify(view).showHeroines(data);
    }

    @Test
    public void shouldShowDetails() {
        final Heroine heroine = Heroine.create(3L, "Aerith", "Aerith Gainsborough", "ability",
                "avatar", "image", "description", "color", "VII", "url");

        presenter.onItemSelected(heroine);
        verify(view).showHeroineDetails(heroine);
    }

}
