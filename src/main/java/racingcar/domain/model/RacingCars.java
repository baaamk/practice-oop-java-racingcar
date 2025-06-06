package racingcar.domain.model;

import racingcar.global.ErrorMessage;

import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> racingCars) {
        validateNameListEmpty(racingCars);
        validateDuplicateName(racingCars);
        this.racingCars = List.copyOf(racingCars);
    }

    public static RacingCars create(List<RacingCar> userInput) {
        return new RacingCars(userInput);
    }

    public List<RacingCar> moveAll() {
        racingCars.forEach(RacingCar::move);
        return racingCars;
    }


    private void validateDuplicateName(List<RacingCar> racingCars) {
        if (racingCars.size() != racingCars.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME);
        }
    }

    private void validateNameListEmpty(List<RacingCar> racingCars) {
        if (racingCars.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME_LIST);
        }
    }


    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
