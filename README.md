# 💰Expense Splitter💰

A mobile app to split bills among friends for meals, trips, or shared costs. Built with Android Studio and Java.

---

## Features

- Create projects for trips or group outings
- Add members from your phone contacts
- Scan receipts using OCR to auto-populate items and prices
- Assign items to specific people per expense
- Proportional tax splitting based on each person's items
- Summary screen showing exactly who owes what
- Mark debts as settled
- Remind friends via WhatsApp deep link

---

## Tech Stack

- **Language**: Java
- **Database**: Room (SQLite)
- **Architecture**: MVVM (Model-View-ViewModel)
- **OCR**: Google ML Kit Text Recognition
- **UI**: Material Design Components

---

## Architecture

The app follows MVVM architecture with a clean separation of layers:

```
UI (Activities/Fragments)
    ↓
ViewModel
    ↓
Repository
    ↓
DAO
    ↓
Room (SQLite)
```

---

## Database Schema

```
Project (id, name, createdDate)
Person (id, name, telno)
Project_Person (projectId, personId)         ← junction table
Expense (id, projectId, description, taxAmount, date)
ExpenseItem (id, expenseId, itemName, itemPrice)
ExpenseItemSplit (expenseItemId, personId)   ← junction table
```

### Key design decisions

- `subtotal` is not stored — it is derived by summing `ExpenseItem.itemPrice` at query time
- Each person's split is also derived — not stored — calculated as their item subtotal plus their proportional share of tax
- The schema is in 3NF — no redundant or transitive dependencies

---

## How the Split Works

1. User scans or manually enters a receipt under a project
2. Each item is assigned to one or more people
3. At the summary screen, per person:
   - Their subtotal = sum of their assigned items
   - Their tax share = (their subtotal / bill subtotal) x tax amount
   - Their total = subtotal + tax share

---

## App Flow

```
Home (project list)
    → Create Project (add members from contacts)
        → Project Detail (list of expenses)
            → Add Expense (scan receipt or manual entry)
                → Review & Edit items
                    → Assign items to people
                        → Summary (who owes what)
```

---

## Project Structure

```
com.yourname.expensesplitter/
    MainActivity.java
    model/
        Project.java
        Person.java
        ProjectMember.java
        Expense.java
        ExpenseItem.java
        ExpenseItemSplit.java
    dao/
        ProjectDao.java
        PersonDao.java
        Project_PersonDao.java
        ExpenseDao.java
        ExpenseItemDao.java
        ExpenseItemSplitDao.java
    database/
        AppDatabase.java
    repository/
        ProjectRepository.java
    viewmodel/
        ProjectViewModel.java
    ui/
        (Activities and Fragments)
    util/
        (Helper classes)
```

---

## Scope Decisions

- Single device, single payer per session. The payer records their own expenses; other payers use their own devices.
- No real payment processing. Settlements are marked manually or triggered via WhatsApp deep link.
- No cloud sync or multi-device shared state.

---

## Getting Started

1. Clone the repository
2. Open in Android Studio
3. Sync Gradle dependencies
4. Run on an emulator or physical device (API 26+)
