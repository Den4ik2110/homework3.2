const val MAX_SUM_MASTERCARD_AND_MAESTRO = 75000_00
const val PERCENT_MASTERCARD_AND_MAESTRO = 0.006
const val FIX_FEE_MASTERCARD_AND_MAESTRO = 20_00
const val PERCENT_VISA_AND_MIR = 0.0075
const val MIN_FEE_VISA_AND_MIR = 35_00

enum class PaymentMethod {
    Visa, Mastercard, Maestro, Mir, VKPay
}

fun main() {
    val amount = 8000_00
    println("Комиссия за перевод составит: ${transferFee(amount)} (сумма приведена в копейках)")
}

fun transferFee(
    transferAmount: Int,
    paymentMethod: PaymentMethod = PaymentMethod.VKPay,
    previousTranslation: Int = 0
): Int {
    return when (paymentMethod) {
        PaymentMethod.Visa, PaymentMethod.Mir -> if (transferAmount * PERCENT_VISA_AND_MIR > MIN_FEE_VISA_AND_MIR) (transferAmount * PERCENT_VISA_AND_MIR).toInt() else MIN_FEE_VISA_AND_MIR
        PaymentMethod.Mastercard, PaymentMethod.Maestro -> if (transferAmount > MAX_SUM_MASTERCARD_AND_MAESTRO) (transferAmount * PERCENT_MASTERCARD_AND_MAESTRO + FIX_FEE_MASTERCARD_AND_MAESTRO).toInt() else 0
        PaymentMethod.VKPay -> 0
    }
}