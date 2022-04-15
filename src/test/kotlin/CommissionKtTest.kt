import org.junit.Test

import org.junit.Assert.*

class CommissionKtTest {

    @Test
    fun transferFee_vkPay() {
        // arrange
        val amount = 8000_00
        val method: PaymentMethod = PaymentMethod.VKPay
        val sumTransaction = 0

        //act
        val result = transferFee(
            transferAmount = amount,
            paymentMethod = method,
            previousTranslation = sumTransaction
        )

        // assert
        assertEquals(0, result)
    }

    @Test
    fun transferFee_mir_ifMore() {
        // arrange
        val amount = 8000_00
        val method: PaymentMethod = PaymentMethod.Mir
        val sumTransaction = 0

        //act
        val result = transferFee(
            transferAmount = amount,
            paymentMethod = method,
            previousTranslation = sumTransaction
        )

        // assert
        assertEquals(60_00, result)
    }

    @Test
    fun transferFee_mir_ifLess() {
        // arrange
        val amount = 400_00
        val method: PaymentMethod = PaymentMethod.Mir
        val sumTransaction = 0

        //act
        val result = transferFee(
            transferAmount = amount,
            paymentMethod = method,
            previousTranslation = sumTransaction
        )

        // assert
        assertEquals(35_00, result)
    }

    @Test
    fun transferFee_masterCard_ifMore() {
        // arrange
        val amount = 80000_00
        val method: PaymentMethod = PaymentMethod.Mastercard
        val sumTransaction = 0

        //act
        val result = transferFee(
            transferAmount = amount,
            paymentMethod = method,
            previousTranslation = sumTransaction
        )

        // assert
        assertEquals(500_00, result)
    }

    @Test
    fun transferFee_masterCard_ifLess() {
        // arrange
        val amount = 8000_00
        val method: PaymentMethod = PaymentMethod.Mastercard
        val sumTransaction = 0

        //act
        val result = transferFee(
            transferAmount = amount,
            paymentMethod = method,
            previousTranslation = sumTransaction
        )

        // assert
        assertEquals(0, result)
    }


}