import React, { useState } from 'react'

const LoanCard = () => {
    
    return (
        <div className='LoanCard'>
                <form>
                    <label>Loan Type</label>
                    <select>
                        <option>Furniture</option>
                        <option>Crockery</option>
                        <option>Software</option>
                        <option>Hardware</option>
                        <option>Stationary</option>
                    </select>
                    <label>Basic Loan Id</label>
                    <input />
                    <label>Duration</label>
                    <input />

                </form>
        </div>
    )
}

export default LoanCard;