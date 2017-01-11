package com.castelanjr.ffheroines2.heroine_details;

import com.castelanjr.ffheroines2.data.DataManager;
import com.castelanjr.ffheroines2.data.model.Heroine;
import com.castelanjr.ffheroines2.util.TestAppScheduler;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

public class HeroineDetailsPresenterTest {

    @Mock
    DataManager dataManager;

    @Mock
    HeroineDetailsView view;

    private HeroineDetailsPresenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        presenter = new HeroineDetailsPresenter(dataManager, new TestAppScheduler());
        presenter.takeView(view);
    }

    @Test
    public void shouldLoadDataAndShowIntoView() {
        final Heroine heroine = Heroine.create(1L, "Terra", "Terra branford", "ability", "avatar",
                "image", "description", "color", "VI", "url");
        when(view.getHeroine()).thenReturn(heroine);

        presenter.loadDetails();

        verify(view).showName(heroine.fullname());
        verify(view).showGame("Final Fantasy " + heroine.game());
        verify(view).showDescription(heroine.description());
        verify(view).showAbility(heroine.ability());
        verify(view).showAvatar(heroine.avatar());
        verify(view).showCover(heroine.avatar());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowIfNull() {
        when(view.getHeroine()).thenReturn(null);

        presenter.loadDetails();
    }

}
