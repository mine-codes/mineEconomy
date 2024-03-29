package pl.minecodes.mineeconomy.command.argument;

import dev.rollczi.litecommands.LiteInvocation;
import dev.rollczi.litecommands.argument.ArgumentName;
import dev.rollczi.litecommands.argument.SingleArgumentHandler;
import dev.rollczi.litecommands.valid.ValidationCommandException;
import eu.okaeri.injector.annotation.Inject;
import pl.minecodes.mineeconomy.data.configuration.Configuration;
import pl.minecodes.mineeconomy.data.configuration.Messages;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

@ArgumentName("value")
public class DoubleArgument implements SingleArgumentHandler<Double> {

    @Inject private Messages messages;
    @Inject private Configuration configuration;

    @Override
    public Double parse(LiteInvocation invocation, String argument) throws ValidationCommandException {
        double parseDouble;
        try {
            parseDouble = Double.parseDouble(argument);
        } catch (NumberFormatException ignored) {
            throw new ValidationCommandException(this.messages.getBalanceOperationParameterIsNotCorrect());
        }

        return new BigDecimal(parseDouble).setScale(this.configuration.getRoundedScale(), RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public List<String> tabulation(String command, String[] args) {
        return Arrays.asList(
                "10", "100", "1000"
        );
    }
}
