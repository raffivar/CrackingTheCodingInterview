package chapter_7_oop_design

import kotlin.collections.ArrayList

class S2CallCenter {
    enum class Level { Respondent, Manager, Director }
    class Employee(val name: String, val level: Level, var isAvailable: Boolean = true)

    private class CallCenter {
        private val employees = hashMapOf<Level, ArrayList<Employee>>()

        init {
            addEmployee(Employee("Raffi", Level.Respondent))
            addEmployee(Employee("George", Level.Manager))
            addEmployee(Employee("Fred", Level.Manager))
            addEmployee(Employee("Max", Level.Director))
        }

        fun addEmployee(employee: Employee) {
            if (!employees.containsKey(employee.level)) {
                employees[employee.level] = arrayListOf()
            }
            employees[employee.level]!!.add(employee)
        }

        fun dispatchCall() {
            for (level in Level.values()) {
                employees[level]?.let {
                    if (it.isNotEmpty()) {
                        val employee = it[0] // get first employee

                        if (employee.isAvailable) {
                            employee.isAvailable = false

                            //move employee to end of list
                            it.remove(employee)
                            it.add(employee)

                            println("[${employee.level}] ${employee.name} took a call.")
                            printAllEmployees()
                            return
                        }
                    }
                }
            }
            println("No-one available to take the call.")
        }

        fun printAllEmployees() {
            for (level in employees) {
                for (e in level.value) {
                    val isAvailable = when (e.isAvailable) {
                        true -> "available"
                        false -> "unavailable"
                    }
                    println("[${e.level}] ${e.name} - $isAvailable")
                }
            }
            println("====================================================")
        }
    }

    private fun startCallCenter() {
        val callCenter = CallCenter()
        callCenter.printAllEmployees()
        for (i in 1..10) {
            callCenter.dispatchCall()
        }
    }

    fun runTest() {
        startCallCenter()
    }
}