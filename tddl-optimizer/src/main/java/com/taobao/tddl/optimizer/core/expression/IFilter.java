package com.taobao.tddl.optimizer.core.expression;


/**
 * 条件表达式
 * 
 * @author jianghang 2013-11-8 下午1:55:54
 * @since 5.1.0
 */
public interface IFilter<RT extends IFilter> extends IFunction<RT> {

    public enum OPERATION {

        AND(0), OR(1), GT(2), LT(3), GT_EQ(4), LT_EQ(5), EQ(6), LIKE(7), IS_NULL(8), IS_NOT_NULL(9), NOT_EQ(10),
        IN(11), IS(12), CONSTANT(13), NULL_SAFE_EQUAL(14), XOR(15);

        private int i;

        OPERATION(int i){
            this.i = i;
        }

        public static OPERATION valueOf(int i) {
            if (i < 0 || i >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }
            return values()[i];
        }

        public String toString() {
            return String.valueOf(i);
        }

        public String getOPERATIONString() {
            switch (this) {
                case AND:
                    return "AND";
                case OR:
                    return "OR";
                case GT:
                    return ">";
                case LT:
                    return "<";
                case IN:
                    return "IN";
                case GT_EQ:
                    return ">=";
                case LT_EQ:
                    return "<=";
                case EQ:
                    return "=";
                case LIKE:
                    return "LIKE";
                case IS_NULL:
                    return "IS NULL";
                case IS:
                    return "IS";
                case IS_NOT_NULL:
                    return "IS NOT NULL";
                case NOT_EQ:
                    return "!=";
                case CONSTANT:
                    return "CONSTANT";
                case NULL_SAFE_EQUAL:
                    return "<=>";
                case XOR:
                    return "XOR";
                default:
                    return null;
            }
        }
    }

    public IFilter setOperation(OPERATION operation);

    public OPERATION getOperation();

}